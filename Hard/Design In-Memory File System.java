import java.util.Optional;

class FileSystem {

    private final Node root;

    public FileSystem() {
        this.root = new DirectoryNode("/");
    }

    public List<String> ls(String path) {
        String[] splits = path.split("/");
        if (splits.length == 0) {
            return buildlsResult((DirectoryNode) root);
        }
        Node curr = root;
        for (int i = 1; i < splits.length - 1; i++) {
            curr = ((DirectoryNode) curr).getNode(splits[i]).get();
        }
        Node lastNode = ((DirectoryNode) curr).getNode(splits[splits.length - 1]).get();
        if (lastNode.isFile()) {
            return Collections.singletonList(lastNode.getName());
        }
        return buildlsResult((DirectoryNode) lastNode);
    }

    public void mkdir(String path) {
        String[] splits = path.split("/");
        createIfNotExists(splits);
    }

    public void addContentToFile(String filePath, String content) {
        String[] splits = filePath.split("/");
        DirectoryNode directoryNode = createIfNotExists(Arrays.copyOfRange(splits, 0, splits.length));
        String fileName = splits[splits.length - 1];
        if (directoryNode.getNode(fileName).isEmpty()) {
            FileNode fileNode = new FileNode(fileName);
            directoryNode.addContent(fileName, fileNode);
        }
        FileNode fileNode = (FileNode) directoryNode.getNode(fileName).get();
        fileNode.addContent(content);
    }

    public String readContentFromFile(String filePath) {
        String[] splits = filePath.split("/");
        DirectoryNode directoryNode = createIfNotExists(Arrays.copyOfRange(splits, 0, splits.length));
        String fileName = splits[splits.length - 1];
        FileNode fileNode = (FileNode) directoryNode.getNode(fileName).get();
        return fileNode.getContents();
    }

    private static List<String> buildlsResult(DirectoryNode curr) {
        return curr
                .getContents()
                .stream()
                .map(Node::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private DirectoryNode createIfNotExists(String[] splits) {
        DirectoryNode curr = (DirectoryNode) root;
        for (int i = 1; i < splits.length; i++) {
            Optional<Node> nextDirectory = curr.getNode(splits[i]);
            if (nextDirectory.isEmpty()) {
                DirectoryNode node = new DirectoryNode(splits[i]);
                curr.addContent(splits[i], node);
                curr = node;
            } else {
                curr = (DirectoryNode) nextDirectory.get();
            }
        }
        return curr;
    }

    private static class FileNode implements Node {

        private final String name;

        private final StringBuilder contents;

        public FileNode(String name) {
            this.name = name;
            this.contents = new StringBuilder();
        }

        public void addContent(String content) {
            this.contents.append(content);
        }

        public String getContents() {
            return contents.toString();
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public boolean isFile() {
            return true;
        }
    }

    private static class DirectoryNode implements Node {

        private String name;

        private final Map<String, Node> contents;

        public DirectoryNode(String name) {
            this.name = name;
            this.contents = new HashMap<>();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean isFile() {
            return false;
        }

        public void addContent(String key, Node node) {
            contents.put(key, node);
        }

        public List<Node> getContents() {
            return contents.values().stream().toList();
        }

        public Optional<Node> getNode(String nodeName) {
            return Optional.ofNullable(contents.getOrDefault(nodeName, null));
        }
    }

    private interface Node {

        String getName();

        boolean isFile();
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
