class FileSystem {
  FileNode root;
  public FileSystem() {
    root = new FileNode("-");
  }

  public boolean createPath(String path, int value) {
    FileNode curr = root;
    String[] directories = path.split("/");
    for (int i = 0; i < directories.length; i++) {
      if (directories[i].equals("")) {
        continue;
      }
      if (!curr.children.containsKey(directories[i])) {
        if (i != directories.length - 1) {
          return false;
        }
        curr.children.put(directories[i], new FileNode(directories[i]));
      }
      curr = curr.children.get(directories[i]);
    }
    if (curr.val != -1) {
      return false;
    }
    curr.val = value;
    return true;
  }

  public int get(String path) {
    FileNode curr = root;
    String[] directories = path.split("/");
    for (int i = 0; i < directories.length; i++) {
      if (directories[i].equals("")) {
        continue;
      }
      if (!curr.children.containsKey(directories[i])) {
        return -1;
      }
      curr = curr.children.get(directories[i]);
    }
    return curr.val;
  }
}


class FileNode {
  String fileName;
  int val;
  Map<String, FileNode> children;
  
  public FileNode(String fileName) {
    this.fileName = fileName;
    val = -1;
    children = new HashMap<>();
  }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
