#!/bin/bash

output_file="/home/hharera/Mol5s/علم النفس الايجابى/علم النفس الايجابى.txt"

if [ -e "$output_file" ]; then
    rm "$output_file"
fi

touch "$output_file"

# Loop through all generated text files and append their contents to the output file
for i in {1..306}; do
    text_file="/home/hharera/Mol5s/علم النفس الايجابى/${i}.txt"

    # Check if the text file exists before attempting to append it
    if [ -e "$text_file" ]; then
        cat "$text_file" >> "$output_file"
        echo "Appended $text_file to $output_file"
    else
        echo "Warning: $text_file not found."
    fi
done

echo "Combination complete. Output saved to $output_file"
