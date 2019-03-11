node('Linux') {
    stage('Clone from CodeHub'){

        git branch: "development", url: 'git@github-sitecore-projects:/IST-QA/sitecore-projects.git'
    }
    stage('Create TestNG XML') {
        def listTests = "${params.'Tests'}".split(",")
        def listTest = listTests.join("\r\n")
        writeFile encoding: 'utf-8', file: 'TestCaseListFile.txt', text: listTest
    }
    boolean grid = false
    boolean cbt = false
    if("${params.'Test Browser'}".contains("IE")){
        cbt = true
    } else {
        grid = true
    }
    stage('Build & Test') {
        String FVersion = "2.0-SNAPSHOT"
        String GridURL = "http://ist0000600.esri.com:4444/wd/hub"
        Boolean ReportDashboardEnabled = false
        Boolean GridEnabled = grid
        Boolean CBTEnabled = cbt
        String ReportServer = "ist000532.esri.com"
        String ProjectName = "${params.'Project_Name'}"
        Boolean ScreenShotOnSuccess = false
        script{
            ReportFolder = ProjectName + (new Date()).format("yyyyMMdd-HHmmss")
            ReportName = ProjectName
        }
        String AppliToolsAppName = "${params.'Project_Name'}"
        String BatchID = "${JOB_NAME}-${BUILD_NUMBER}"
        String BatchName = "${params.'Test Batch Friendly Name'}"
        String Browser = "${params.'Test Browser'}".toLowerCase().trim()
        String TestEnvironment = "${params.'Test Environment'}"
        String EnableTPReport = true

        //Validate batch name
        if(BatchName?.trim()){
            BatchName = "$BatchName-${BUILD_NUMBER}"
        }else{
            BatchName = BatchID
        }

        def cmd = """ -PFRAMEWORKVERSION=$FVersion -PTESTCASELISTFILE=TestCaseListFile.txt -PTESTBROWSER=$Browser \
-PENABLETPREPORT=$EnableTPReport -Dreport.dashboard.enabled=$ReportDashboardEnabled -Dreport.server=$ReportServer -Dreport.name=$ReportName \
-Dgrid.url=$GridURL -Dproject.name=$ReportName -Dversion=$FVersion -Dscreenshot.on.success=$ScreenShotOnSuccess \
-Dgrid.enabled=$GridEnabled -Dcbt.enabled=$CBTEnabled -Dtest.environment=$TestEnvironment -Dappli.batchid="$BatchID" \
-Dreport.folder=$ReportFolder -Dappli.batchname="$BatchName" -Dtest.app="$AppliToolsAppName" \
--refresh-dependencies clean build"""

        if (isUnix()) {
            sh "./gradlew ${cmd}"
        } else {
            bat "gradlew.bat ${cmd}"
        }
    }

    stage('Publish results') {
        String TestReport = "TestReport"
        report = getResultsFromTestNG()
        echo report.toString()
        step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${ReportFolder}", reportFiles: "${ReportName}.html", reportName: "$TestReport", reportTitles: ''])

        String Status = currentBuild.currentResult
        String Body = "Results not generated"
        if (fileExists("${ReportFolder}")) {
            Body = "Please go to ${BUILD_URL}$TestReport"
        }

        mail (to: "${params.'Email Address'}",
                subject: "Job:'${JOB_NAME}' Build:'${BUILD_NUMBER}' Status:$Status Result:$report" ,
                body: Body)

    }
}

def getResultsFromTestNG(){

    def ResultList = []
    def intS,intP,intF,intI, intT

    def reportData = readFile 'build/reports/tests/test/testng-results.xml'
    //reportData = "<testng-results skipped=\"0\" failed=\"0\" ignored=\"0\" total=\"1\" passed=\"1\">"
    def lstTestNG = reportData.split("\n")

    for (String txt in lstTestNG){
        echo txt
        if(txt.substring(0,15) == "<testng-results"){

            txt = txt.replace("<testng-results ","")
            txt = txt.replace(">","")
            txt = txt.replace("\"","")

            def arrTxt = txt.split(" ")
            for(arrT in arrTxt){
                echo arrT.toString()
                def res =  arrT.split("=")
                ResultList.add(res)

                if(res.length == 2 ){
                    switch (res[0]){
                        case "skipped":
                            intS = res[1]
                            break
                        case "failed":
                            intF = res[1]
                            break
                        case "ignored":
                            intI = res[1]
                            break
                        case "total":
                            intT = res[1]
                            break
                        case "passed":
                            intP = res[1]
                            break
                    }
                }
            }
            break
        }
    }

    echo ResultList.toString()
    if (intS.contains('0') && intI.contains('0')){
        echo "No skipped or ignored"
    } else {
        currentBuild.result = "UNSTABLE"
    } 
    if(intF.contains('0')) {
        echo "No failed test cases"
        } else {
        currentBuild.result = "FAILED"
    }
    return ResultList
}
