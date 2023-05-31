# Selenium
selenium rest assured sample files
To update maven dependencies use :mvn versions:display-dependency-updates
To clean and run the tests use below:mvn clean install

#  Install Google Chrome in Linux server
# Refer below article
https://pavankumar-89104.medium.com/set-up-and-run-selenium-on-centos-d7931391208c

curl https://intoli.com/install-google-chrome.sh | bash
# It allows to run chrome in linux without any UI 
yum install xorg-x11-server-Xvbf
Xvfb -ac:99 -screen 0 1280*1024*16 & export Display=:99