#!/bin/bash
print_usage() {
    echo "Usage: $0 [problem] [skeleton (default java)]"
}

if [ $# -eq 0 ]; then
    print_usage
    exit
fi

echo Creating directory for $1 using skeleton ${2:-java}
mkdir $1
cp -r _templates/${2:-java}/* $1
cd $1

echo Downloading samples
curl https://open.kattis.com/problems/$1/file/statement/samples.zip --output samples.zip
unzip samples.zip -d samples/
rm samples.zip

echo Done!
