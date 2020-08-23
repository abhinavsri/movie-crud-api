docker run -d -p 6033:3306 --name=movie-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=movie_crud" mysql
docker image ls
docker container ls

docker exec -it movie-mysql bash;
docker build -f dockerfile -t movie_crud .
docker run -t --link movie-mysql:mysql -p 10222:10222 movie_crud