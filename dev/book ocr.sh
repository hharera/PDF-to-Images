#!/bin/bash

path="/home/hharera/Mol5s/الأسس النفسية لتنمية الشخصية الإيجابية للمسلم المعاصر/pages";

for ((i = 47; i <= 47; i++)); do
    filename="${path}/${i}.png"
    output="${path}/${i}"

    tesseract --dpi 70 "$filename" "$output" -l ara

    echo "Processed $filename"
done
