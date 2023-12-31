#!/bin/bash

path="/home/hharera/Mol5s/علم النفس الايجابى/";

for ((i = 1; i <= 1000; i++)); do
    filename="${path}/${i}.png"
    output="${path}/${i}"

    tesseract "$filename" "$output" -l ara

    echo "Processed $filename"
done
