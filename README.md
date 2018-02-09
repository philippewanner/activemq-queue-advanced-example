Install apache ActiveMQ with Homebrew package manager:

$ brew install apache-activemq

To have launchd start activemq now and restart at login:
  brew services start activemq
Or, if you don't want/need a background service you can just run:
  activemq start

The installation directory is /usr/local/Cellar/activemq/x.x.x/

http://127.0.0.1:8161/admin/ 

login/pass: admin/admin

Inspired from https://github.com/tuhrig/Review_System_Demo