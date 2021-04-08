package geeks.Algorithms.Lesson6;

public class Tree {
    private Node root;

    public void inset(Person person){
        Node node = new Node();
        node.person = person;
        if(root == null)
            root = node;
        else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(person.id < current.person.id){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
    public Node find(int key){
        Node current = root;
        while (current.person.id != key){
            if(key < current.person.id)
                current = current.leftChild;
            else
                current = current.rightChild;
            if(current == null)
                return null;
        }
        return current;
    }
    public void preOrder(Node rootNode){
        if(rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }
    public void postOrder(Node rootNode){
        if(rootNode != null){
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }
    public void inOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min(){
        Node current = root, last = null;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max(){
        Node current = root, last = null;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }


    public boolean delete(int id){
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.person.id != id){
            parent = current;
            if(id < current.person.id){
                isLeftChild = true;
                current = current = current.leftChild;
            } else{
                isLeftChild = false;
                current = current.rightChild;
            }

            if(current == null){
                return false;
            }
        }
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(current.rightChild == null){
            if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }else{
            Node successor = getSuccesor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccesor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }
    public void  displayTree(){

        System.out.println("Симетричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(root);
    }
}
