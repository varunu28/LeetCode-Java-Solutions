class FileSystem {

  private FileNode root;

  public FileSystem() {
    this.root = new FileNode();
  }

  public boolean createPath(String path, int value) {
    String[] split = path.split("/");
    FileNode node = root;
    for (int i = 1; i < split.length - 1; i++) {
      if (!node.children.containsKey(split[i])) {
        return false;
      }
      node = node.children.get(split[i]);
    }
    if (node.children.containsKey(split[split.length - 1])) {
      return false;
    }
    node.children.put(split[split.length - 1], new FileNode(value));
    return true;
  }

  public int get(String path) {
    String[] split = path.split("/");
    FileNode node = root;
    for (int i = 1; i < split.length; i++) {
      if (!node.children.containsKey(split[i])) {
        return -1;
      }
      node = node.children.get(split[i]);
    }
    return node.value == null ? -1 : node.value;
  }

  private static class FileNode {
    private final Map<String, FileNode> children;
    private Integer value;

    public FileNode() {
      this.children = new HashMap<>();
    }

    public FileNode(Integer value) {
      this.children = new HashMap<>();
      this.value = value;
    }
  }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
