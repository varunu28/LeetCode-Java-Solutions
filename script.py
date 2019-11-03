#!/usr/bin/env python3
import os
from os import listdir, getcwd
from os.path import isfile, join


current_dir = getcwd()

# Clean up
current_files = os.listdir(current_dir)
for item in current_files:
    if item.endswith(".md"):
        os.remove(os.path.join(current_dir, item))

tree_path = "https://github.com/varunu28/LeetCode-Java-Solutions/tree/master/"
levels = ["Easy", "Medium", "Hard"]
for level in levels:
    onlyfiles = [f for f in listdir(current_dir + "/" + level)]
    f= open(level + ".md","w+")
    f.write("# " + level + " LeetCode-Java-Solutions \n")
    f.write("S.no | Coding Problem \n")
    f.write("--- | --- \n")
    count = 1
    for file_name in onlyfiles:
        only_name = file_name[:file_name.find('.')]
        f.write(str(count) + "|" + '[{}]({})\n'.format(only_name, (tree_path + level + file_name)))
        count = count + 1
    print(level + ": " + str(count))
    f.close()
