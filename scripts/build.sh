#!/ban/bash
RUNNER_CORE="/home/aka/programming/java/cuguge/app"
RUNNER_DIR="/home/aka/programming/java/cuguge/app/runner/target"

cd $RUNNER_CORE
mvn clean package -Dmaven.test.skip=true
java -jar "$RUNNER_DIR/runner-0.0.1-SNAPSHOT.jar"
