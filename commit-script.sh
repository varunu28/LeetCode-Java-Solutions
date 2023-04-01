#!/bin/sh

git add .

if git status | grep -q 'modified'; then
    status=$(git status | grep 'modified')
    modified_file=${status##*/}
    git commit -m "Updated ${modified_file}"
elif git status | grep -q 'new file:'; then
    status=$(git status | grep 'new file:')
    added_file=${status##*/}
    git commit -m "Added ${added_file}"
fi

git push
