/*
 * Binary Search Tree
 * 
 * Stores the root node and all methods to traverse/insert/delete/modify
 */
public class BinarySearchTree 
{
    private Node root;

    public BinarySearchTree insert(Employee inEmp)
    {
        root = insert(inEmp, root);
        return this;
    }

    public Node getRoot()
    {
        return root;
    }

    public void modifyName(int eID, Node temp, String name)
    {
        if(temp == null)
        {
            return;
        }
        else if(temp.getEmployee().getEID() == eID)
        {
            temp.getEmployee().setName(name);
            return;
        }
        if(eID < temp.getEmployee().getEID())
        {
            modifyName(eID, temp.getLeft(), name);
        }
        else
        {
            modifyName(eID, temp.getRight(), name);
        }
    }

    public void modifyAddress(int eID, Node temp, String address)
    {
        if(temp == null)
        {
            return;
        }
        else if(temp.getEmployee().getEID() == eID)
        {
            temp.getEmployee().setAddress(address);
            return;
        }
        if(eID < temp.getEmployee().getEID())
        {
            modifyAddress(eID, temp.getLeft(), address);
        }
        else
        {
            modifyAddress(eID, temp.getRight(), address);
        }
    }
    
    public void modifyPhoneNumber(int eID, Node temp, String number)
    {
        if(temp == null)
        {
            return;
        }
        else if(temp.getEmployee().getEID() == eID)
        {
            temp.getEmployee().setPhoneNumber(number);
            return;
        }
        if(eID < temp.getEmployee().getEID())
        {
            modifyPhoneNumber(eID, temp.getLeft(), number);
        }
        else
        {
            modifyPhoneNumber(eID, temp.getRight(), number);
        }
    }

    public Node insert(Employee inEmp, Node temp)
    {
        if (temp == null)
        {
            return new Node(inEmp);
        }
        if(temp.getEmployee().getEID() < 0)
        {
            temp.setLeft(insert(inEmp, temp.getLeft()));
        }
        else if(temp.getEmployee().getEID() > 0)
        {
            temp.setRight(insert(inEmp, temp.getRight()));
        }
        return temp;
    }

    public void delete(int deleteID)
    {
        root = delete(deleteID, root);
    }

    public Node delete(int deleteID, Node temp)
    {
        if(temp == null)
        {
            return null;
        }
        if(deleteID < temp.getEmployee().getEID())
        {
            temp.setLeft(delete(deleteID, temp.getLeft()));
        }
        else if(deleteID > temp.getEmployee().getEID())
        {
            temp.setRight(delete(deleteID, temp.getRight()));
        }
        else
        {
            if(temp.getLeft() == null && temp.getRight() == null)
            {
                return null;
            }
            else if(temp.getLeft() == null)
            {
                return temp.getRight();
            }
            else if(temp.getRight() == null)
            {
                return temp.getLeft();
            }
        }
        return temp;
    }
    public void traverseInOrder(Node temp)
    {
        if(temp == null)
        {
            return;
        }
        traverseInOrder(temp.getLeft());
        System.out.println(temp);
        traverseInOrder(temp.getRight());
    }

    public void traversePreOrder(Node temp)
    {
        if(temp == null)
        {
            return;
        }
        System.out.println(temp);
        traversePreOrder(temp.getLeft());
        traversePreOrder(temp.getRight());
    }

    public void traversePostOrder(Node temp)
    {
        if(temp == null)
        {
            return;
        }
        traversePostOrder(temp.getLeft());
        traversePostOrder(temp.getRight());
        System.out.println(temp);
    }

    public boolean isEmpty()
    {
        if(root == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
