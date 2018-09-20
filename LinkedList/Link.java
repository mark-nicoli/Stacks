//Linklist sample code

public class Link {

    public String bookName;
    public int millionsSold;
       
    public Link next;
    public Link(String bookName, int millionsSold){
        this.bookName = bookName;
        this.millionsSold = millionsSold;
        
    }

    public void display(){
        System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");
        
    }
    public String toString(){
        return bookName;
        
    }

    public static void main(String[] args) {
        LinkList theLinkedList = new LinkList();
        
                
        theLinkedList.insertFirstLink("Don Quixote", 500);
        theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
        theLinkedList.insertFirstLink("The Lord of the Rings", 150);
        theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
        
        theLinkedList.display();
        
        System.out.println("Value of first in LinkedList " + theLinkedList.firstLink + "\n");
        
        theLinkedList.removeFirst();
        theLinkedList.display();
        System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " Was Found");
        theLinkedList.removeLink("A Tale of Two Cities");
        System.out.println("\nA Tale of Two Cities Removed\n");
        theLinkedList.display();
    }
}
       
class LinkList{

    public Link firstLink;
    LinkList(){
        firstLink = null;

    }
    public boolean isEmpty(){
        return(firstLink == null);

    }

    public void insertFirstLink(String bookName, int millionsSold){
        Link newLink = new Link(bookName, millionsSold);

        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirst(){
        Link linkReference = firstLink;
        if(!isEmpty()){
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList");
        }
        return linkReference;
    }

    public void display(){
        Link theLink = firstLink;

        while(theLink != null){
            theLink.display();
            System.out.println("Next Link: " + theLink.next);

            theLink = theLink.next;

            System.out.println();

        }

    }
    public Link find(String bookName){

        Link theLink = firstLink;
        if(!isEmpty()){
            while(theLink.bookName != bookName){
                if(theLink.next == null){
                    return null;

                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }
    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        while(currentLink.bookName != bookName){
            if(currentLink.next == null){
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;

            }
        }
        if(currentLink == firstLink){
            // LinkedList so just assign next to firstLin

            firstLink = firstLink.next;
        } else {
            // If you are here there was a match in a Link othe
            // than the firstLink. Assign the value of next for
            // the Link you want to delete to the Link that's
            // next previously pointed to the reference to remove
            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstLink);
            previousLink.next = currentLink.next;

        }
        return currentLink;
    }
}
