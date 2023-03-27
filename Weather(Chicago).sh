#!/bin/bash

url="https://api.open-meteo.com/v1/forecast?latitude=41.76&longitude=-88.29&hourly=temperature_180m&current_weather=true&forecast_days=1&timezone=America%2FChicago"

response=$(curl -s "$url")
result=""
temp3=0

for (( i=0; i<${#response}-15; i++ ))
do
if [ "${response:i:15}" = "temperature_180" ]
then
temp3=$((temp3+1))
fi
if [ "$temp3" -eq 2 ]
then
result="${response:i+19:${#response}-i-23}"
break
fi
done

now=$(date +'%H')
countofcomma=0
temperature=""

for (( i=0; i<${#result}; i++ ))
do
if [ "${result:i:1}" = "," ]
then
countofcomma=$((countofcomma+1))
fi
if [ "$countofcomma" -eq "$now" ]
then
temp=0
j=$i
while [ "${result:j-1:1}" != "," ]
do
j=$((j-1))
temp=$((temp+1))
done
temperature="${result:i-temp:temp}"
break
fi
done

echo -e "\e[32mThe current temperature in Chicago is:\e[0m \e[31m$temperature  C\e[0m"
