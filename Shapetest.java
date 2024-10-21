abstract class shape{
     int dimension1;
     int dimension2;

public shape(int dimension1,int dimension2)
{
    this.dimension1=dimension1;
    this.dimension2=dimension2;

}


public abstract void printArea();
}


class Rectangle extends shape
{
public Rectangle(int length,int breadth)
{super(length,breadth);

}
@Override
public void printArea(){
int area=dimension1*dimension2;
System.out.println("Area of Recatngle is:"+area);


}

}

class Triangle extends shape{

public Triangle(int base,int height)
{

super(base,height);
}

@Override
public void printArea(){


double area=0.5*dimension1*dimension2;
System.out.println("Area of Traingle is:"+area);

}
}
class Circle extends shape {
public Circle (int radius)
{

super(radius,0);
}
@Override
public void printArea(){
double area=3.14*dimension1*dimension1;
System.out.println("Area  of  circle is:"+area);

}
}



public class Shapetest{


public static void  main (String[] args){
shape rectangle =new Rectangle(3,5);
rectangle.printArea();
shape triangle =new Triangle(3,5);
triangle.printArea();
shape circle =new Circle(7);
circle.printArea();
}






}


