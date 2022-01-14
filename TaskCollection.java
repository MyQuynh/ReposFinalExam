package ReposFinalExam;
public class TaskCollection {
  public static void main(String[] args) {
    
  }

  TaskNode root;

  public void addTask(Task v) {
    TaskNode n = new TaskNode(v);
    // Empty tree?
    if (root == null) {
      root = n;
      return;
    }
    // Find the appropriate location
    TaskNode temp = root;
    while (true) {
      if (temp.value.isGreater(v)) {
        if (temp.left == null) {
          temp.left = n;
          break;
        } else {
          temp = temp.left;
        }        
      } else {
        if (temp.right == null) {
          temp.right = n;
          break;
        } else {
          temp = temp.right;
        }        
      }
    }
  }

  public Task search(String code) {
    TaskNode temp = root;
    Task v = new Task("abc", code);
    while (true) {
      if (temp.value.code.equals(code)) {
        return temp.value;
      }
      if (temp.value.isGreater(v)) {
        if (temp.left == null) {
          return null;
        } else {
          temp = temp.left;
        }
      } else {
        if (temp.right == null) {
          return null;
        } else {
          temp = temp.right;
        }
      }
    }
  }

}

class Task  {
  String name;
  String code;

  public Task(String n, String c) {
    name = n;
    code = c;
  }

  boolean isGreater(Task other) {
    // YYMMDD<Order>
    int d1 = Integer.parseInt(code.substring(0, 6));
    int d2 = Integer.parseInt(other.code.substring(0, 6));
    char c1 = code.charAt(6);
    char c2 = other.code.charAt(6);
    if (d1 != d2) {
      return d1 > d2;
    }
    return c1 > c2;
  }
}

class TaskNode {
  Task value;
  TaskNode left, right;

  public TaskNode(Task v) {
    value = v;
    left = right = null;
  }
}