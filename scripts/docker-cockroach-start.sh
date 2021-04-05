docker run -d --name=roachieboi --hostname=roachieboi -p 26257:26257 -p 8080:8080 cockroachdb/cockroach:v20.1.5 start --insecure --http-addr=:8080
sleep 1s
docker exec -it roachieboi ./cockroach sql --insecure --execute="CREATE USER IF NOT EXISTS dev;"
docker exec -it roachieboi ./cockroach sql --insecure --execute="CREATE DATABASE IF NOT EXISTS cardsagainsthumanity;"
docker exec -it roachieboi ./cockroach sql --insecure --execute="GRANT ALL ON DATABASE cardsagainsthumanity TO dev;"