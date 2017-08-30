TOMCAT_ADMIN=/usr/local/tomcat8/webapps/
cd /data/workspace/GuoWei/
#git checkout . && git pull origin
cd /data/workspace/GuoWei/guowei-manager
mvn install
cd $TOMCAT_ADMIN
rm -rf ROOT
mkdir ROOT
cd ROOT
mv /data/workspace/GuoWei/guowei-manager/guowei-manager-web/target/guowei-manager-web.war /usr/local/tomcat8/webapps/ROOT/
jar -xvf guowei-manager-web.war
sh $TOMCAT_BIN/shutdown.sh
sh $TOMCAT_BIN/startup.sh
