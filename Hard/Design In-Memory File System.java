class FileSystem {

  private final FileNode root;

  public FileSystem() {
    this.root = new FileNode("ROOT", FileType.FOLDER);
  }

  /*
   * If path is a file path, returns a list that only contains this file's name.
   * If path is a directory path, returns the list of file and directory names in this directory.
   * */
  public List<String> ls(String path) {
    String[] split = path.split("/");
    FileNode currNode = root;
    for (int i = 1; i < split.length; i++) {
      currNode = currNode.subFiles.get(split[i]);
    }
    if (currNode.fileType.equals(FileType.FILE)) {
      return List.of(currNode.value);
    } else {
      return currNode.subFiles.keySet().stream().sorted().collect(Collectors.toList());
    }
  }

  /*
   * Makes a new directory according to the given path. The given directory path does not exist.
   * If the middle directories in the path do not exist, you should create them as well.
   * */
  public void mkdir(String path) {
    String[] splits = path.split("/");
    FileNode currNode = root;
    for (int i = 1; i < splits.length; i++) {
      String fileName = splits[i];
      if (!currNode.subFiles.containsKey(fileName)) {
        currNode.subFiles.put(fileName, new FileNode(fileName, FileType.FOLDER));
      }
      currNode = currNode.subFiles.get(fileName);
    }
  }

  /*
   * If filePath does not exist, creates that file containing given content.
   * If filePath already exists, appends the given content to original content.
   * */
  public void addContentToFile(String filePath, String content) {
    String[] splits = filePath.split("/");
    FileNode currNode = root;
    for (int i = 1; i < splits.length - 1; i++) {
      String folderName = splits[i];
      if (!currNode.subFiles.containsKey(folderName)) {
        currNode.subFiles.put(folderName, new FileNode(folderName, FileType.FOLDER));
      }
      currNode = currNode.subFiles.get(folderName);
    }
    String fileName = splits[splits.length - 1];
    if (!currNode.subFiles.containsKey(fileName) ||
        !currNode.subFiles.get(fileName).fileType.equals(FileType.FILE)) {
      currNode.subFiles.put(fileName, new FileNode(fileName, FileType.FILE));
    }
    currNode = currNode.subFiles.get(fileName);
    currNode.addContentToFile(content);
  }

  /*
   * Returns the content in the file at filePath.
   * */
  public String readContentFromFile(String filePath) {
    String[] splits = filePath.split("/");
    FileNode currNode = root;
    for (int i = 1; i < splits.length; i++) {
      String folderName = splits[i];
      currNode = currNode.subFiles.get(folderName);
    }
    return currNode.fileContent.toString();
  }

  enum FileType {
    FILE, FOLDER
  }

  static class FileNode {

    private final String value;
    private final Map<String, FileNode> subFiles;
    private final FileType fileType;
    private StringBuilder fileContent;

    public FileNode(String value, FileType fileType) {
      this.value = value;
      this.fileType = fileType;
      this.subFiles = new HashMap<>();
    }

    public void addContentToFile(String content) {
      if (fileContent == null) {
        fileContent = new StringBuilder();
      }
      fileContent.append(content);
    }
  }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
