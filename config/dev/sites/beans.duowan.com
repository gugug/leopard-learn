upstream resins {
    server resin1.beans.leopard.yy.com:8081 weight=1;
    server resin2.beans.leopard.yy.com:8081 weight=1;
}


server {
        server_name  beans.game.yy.com;
      

        root   		/data/app/beans/htdocs/beans-web/;
		access_log  /data2/log/nginx/beans.access.log  main;
        error_log 	/data2/log/nginx/beans.error.log;
        
        include server.conf;
      
		
		rewrite ^/$ /index.html last;
}


