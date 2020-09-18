class MyHashSet {

  /** Initialize your data structure here. */
  private Bucket[] bucketArray;
  private int keyRange;
  public MyHashSet() {
    this.keyRange = 769;
    this.bucketArray = new Bucket[this.keyRange];
    for (int i = 0; i < this.keyRange; i++) {
      this.bucketArray[i] = new Bucket();
    }
  }
  
  protected int _hash(int key) {
    return key % this.keyRange;
  }

  public void add(int key) {
    int bucketIndex = this._hash(key);
    this.bucketArray[bucketIndex].insert(key);
  }

  public void remove(int key) {
    int bucketIndex = this._hash(key);
    this.bucketArray[bucketIndex].delete(key);
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bucketIndex = this._hash(key);
    return this.bucketArray[bucketIndex].exists(key);
  }
}


class Bucket {
  private BSTree tree;
  
  public Bucket() {
    tree = new BSTree();
  }
  
  public void insert(Integer key) {
    this.tree.root = this.tree.insertToBST(this.tree.root, key);
  }
  
  public void delete(Integer key) {
    this.tree.root = this.tree.deleteFromBST(this.tree.root, key);
  }
  
  public boolean exists(Integer key) {
    TreeNode node = this.tree.searchBST(this.tree.root, key);
    return node != null;
  }
}


class BSTree {
  TreeNode root = null;
  
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || val == root.val) {
      return root;
    }
    return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
  }
  
  public TreeNode insertToBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    
    if (root.val < val) {
      root.right = insertToBST(root.right, val);
    }
    else if (root.val > val) {
      root.left = insertToBST(root.left, val);
    }
    else {
      return root;
    }
    return root;
  }
  
  public TreeNode deleteFromBST(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val < key) {
      root.right = deleteFromBST(root.right, key);
    }
    else if (root.val > key) {
      root.left = deleteFromBST(root.left, key);
    }
    else {
      if (root.left == null && root.right == null) {
        root = null;
      }
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteFromBST(root.right, root.val);
      }
      else {
        root.val = predecessor(root);
        root.left = deleteFromBST(root.left, root.val);
      }
    }
    return root;
  }
  
  private int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) {
      root = root.left;
    }
    return root.val;
  }
    
  private int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) {
      root = root.right;
    }
    return root.val;
  }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  
  public TreeNode(int x) {
    val = x;
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
