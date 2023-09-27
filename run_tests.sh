echo "Invalid tests (must return FAIL)"
for test_file in ./test/invalid/*.txt; do
    java -jar rover.jar "$test_file" > /dev/null 2>&1
  # Check the test program's output
    if [ $? -eq 0 ]; then
      echo "${test_file} : OK"
    else
      echo "${test_file} : FAIL"
    fi
done

echo "Valid tests (must return OK)"
for test_file in ./test/valid/*.txt; do
    java -jar rover.jar "$test_file" > /dev/null 2>&1
  # Check the test program's output
    if [ $? -eq 0 ]; then
      echo "${test_file} : OK"
    else
      echo "${test_file} : FAIL"
    fi
done