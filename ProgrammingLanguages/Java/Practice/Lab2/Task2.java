class TreeNode
{
	TreeNode left;
	TreeNode right;
	String data;
}

class Task2 
{ 
 
  public static void main(String[] args)
  {       
	  TreeNode node = null;    
	  node = insert(node, "Jasna");
	  node = insert(node, "Ana");  
	  //System.out.println(node.data);
	  //System.out.println(node.right.data);
	  node = insert(node, "Ivana");  
	  node = insert(node, "Anamarija");  
	  node = insert(node, "Vesna");  
	  node = insert(node, "Kristina");    
	  System.out.println("Writing tree inorder:");  
	  writeTree(node); 
	 
	  node = reverseTreeOrder(node);     
	  System.out.println("Writing reversed tree inorder:");  
	  writeTree(node);    
	  int size = sizeOfTree(node);  
	  System.out.println("Number of nodes in tree is "+size+".");    
	  boolean found = containsData(node, "Ivana");  
	  System.out.println("Searched element is found: "+found);
  }
  
  static boolean containsData(TreeNode treeRoot, String data) 
  {
	  if (treeRoot == null)
	  {
		  return false;
	  }
	  else
	  {
		  if (treeRoot.data.equals(data))
		  {
			  return true;
		  }
		  return (containsData(treeRoot.left, data) || containsData(treeRoot.right, data));
	  }
  }
  
  static int sizeOfTree(TreeNode treeRoot) 
  {
	  if (treeRoot == null)
	  {
		  return 0;
	  }
	  else
	  {
		  return sizeOfTree(treeRoot.left) + sizeOfTree(treeRoot.right) + 1;
	  }
  }
  
  static TreeNode insert(TreeNode treeRoot, String data) 
  {
	  if (treeRoot == null)
	  {
		  System.out.println("Insert");
		  treeRoot = new TreeNode();
		  treeRoot.data = data;
		  treeRoot.left = null;
		  treeRoot.right = null;
	  }
	  else
	  {
		  if (treeRoot.data.compareTo(data) > 0)
		  {
			  //Have to catch the return values; if not, treeRoot.right will keep pointing to null
			  System.out.println("Right");
			  treeRoot.right = insert(treeRoot.right, data);
		  }
		  else
		  {
			  System.out.println("Left");
			  treeRoot.left = insert(treeRoot.left, data);
		  }
	  }
	  
	  return treeRoot;
  }
  
  static void writeTree(TreeNode treeRoot) 
  {
	  if (treeRoot != null)
	  {
		  writeTree(treeRoot.left);
		  System.out.println(treeRoot.data);
		  writeTree(treeRoot.right);
	  }
  }
  
  static TreeNode reverseTreeOrder(TreeNode treeRoot) 
  {
	  if (treeRoot == null)
	  {
		  return treeRoot;
	  }
	  else
	  {
		  reverseTreeOrder(treeRoot.left);
		  reverseTreeOrder(treeRoot.right);
		  TreeNode swapper = treeRoot.left;
		  treeRoot.left = treeRoot.right;
		  treeRoot.right = swapper;
		  return treeRoot;
	  }
  }
}