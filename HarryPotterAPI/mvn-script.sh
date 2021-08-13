echo "--- START OF MVN SCRIPT ---"
echo "Now running maven commands..."
mvn clean -X
mvn compile -X
mvn deploy -X
echo "--- END OF MVN SCRIPT ---"