/*
 * Node class
 * 
 * Stores the employee and has pointers to left/right and get/set methods.
 */
public class Node 
{
    private Employee employee;
    private Node left;
    private Node right;

    public Node(Employee inEmp)
    {
        employee = inEmp;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    public Node getLeft()
    {
        return left;
    }
    public void setLeft(Node temp)
    {
        left = temp;
    }

    public Node getRight()
    {
        return right;
    }
    public void setRight(Node temp)
    {
        right = temp;
    }

    public String toString()
    {
        return employee.toString();
    }
}
