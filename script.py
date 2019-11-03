#!/usr/bin/env python3
import os
from os import listdir, getcwd
from os.path import isfile, join


current_dir = getcwd()

# Clean up
# current_files = os.listdir(current_dir)
# for item in current_files:
#     if item.endswith(".md"):
#         os.remove(os.path.join(current_dir, item))

tree_path = "https://github.com/varunu28/LeetCode-Java-Solutions/tree/master/"
levels = ["Easy", "Medium", "Hard"]
for level in levels:
    if os.path.exists(current_dir + "/" + level + "/README.md"):
        os.remove(current_dir + "/" + level + "/README.md")
    onlyfiles = [f for f in listdir(current_dir + "/" + level)]
    f= open(current_dir + "/" + level + "/README.md","w+")
    f.write("# " + level + " LeetCode-Java-Solutions \n")
    f.write("S.no | Coding Problem \n")
    f.write("--- | --- \n")
    count = 1
    for file_name in onlyfiles:
        only_name = file_name[:file_name.find('.')]
        updated_file_name = file_name.replace(' ', '%20')
        f.write(str(count) + "|" + '[{}]({})\n'.format(only_name, (tree_path + level + "/" + updated_file_name)))
        count = count + 1
    print(level + ": " + str(count))
    f.close()
