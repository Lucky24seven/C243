package JuicyCode;

import java.util.*;

public class DynamicArray 
{

    int size;
    int capacity = 10;
    int[] array;

	public DynamicArray()
	{
		this.array =  new int[capacity];
	}
	
	public DynamicArray(int capacity)
	{
		this.capacity = capacity;
        this.array = new int[capacity];
	}

	public DynamicArray(DynamicArray ArrayCopy)
	{
		this.size = ArrayCopy.size;
		this.capacity = ArrayCopy.capacity;
		this.array = ArrayCopy.array;
	}
	
	//enqueue for Dynamic Array ArrayQueue
	//push for Dynamic Array ArrayStack
	public void addLast(int data)
	{
		if(size >= capacity)
		{
			expandArr();
		}
		array[size] = data;
		size++;
	}
	
	//dequeue for Dynamic Array ArrayQueue
	public int removeFront()
	{
		int retVal;
	
		if(isEmpty())
			return -1;
		
		retVal = array[0];
		int[] tempArray = Arrays.copyOfRange(array, 1, array.length);
		array = tempArray;
		size--;
		shrinkSize();
		
		return retVal;
	}

	//peek for Dynamic Array ArrayQueue
	public int getFirst()
	{
		if(isEmpty())
			return -1;
		
        return array[0];
    }
	
	
	//pop for Dynamic Array ArrayStack
	public int removeTop()   
	{   
		int retVal;
		
		if(isEmpty())
			return -1;

		retVal = array[size-1];
		if (size > 0)   
		{   
			array[size - 1] = 0;   
			size--;   
		}
		return retVal;
	}

	
	//peek for Dynamic Array ArrayStack
	public int getLast()
	{
		if(isEmpty())
			return -1;
		
        return array[size - 1];
    }


	//isEmpty ArrayQueue
	//isEmpty ArrayStack
	public boolean isEmpty()
	{
		return size == 0;
	}

	//size ArrayQueue
	//size ArrayStack
	public int getSize()
	{
		if(isEmpty())
			return 0;
		return size;
	}
	
	//clear ArrayQueue
	//clear ArrayStack
	public void clearArr()
	{
		size = 0;
	}
	
	//Helper function
	public void expandArr()
	{
		int newCapacity = capacity * 2;
		int[] newArray = new int[newCapacity];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
		}
		capacity = newCapacity;
		array = newArray;
	}
	
	//Helper function	
	public void shrinkSize()   
	{   
		
		if(size > (capacity/2)) {
			return;
		}
		
		this.capacity /=2;
		int[] newData = new int[size];

		for(int i = 0; i < size; i++) 
		{
			newData[i] = array[i];
		}

		array = newData;
	}   
		
	public int capacity()
	{
		return capacity;
	}
	
	public String toString()
	{
        String string = "{";
        for(int i = 0; i < size; i++)
        {
        	if(i == size - 1)
        	{
        		string += array[i];
        	}
        	else
        	{
        		string += array[i] + ",";
        	}
        }
        string += "}";

        return string;
    }
	
	
	public int getFrom(int idx)
	{
		if(isEmpty())
			return -1;
		
        return array[idx];
    }
	public void addFirst(int data)
	{
		if(size >= capacity)
		{
			expandArr();
		}
		int[] tempArray = Arrays.copyOfRange(array, 0, array.length);
		array[0] = data;
		for(int i = 1; i < size + 1; i++)
		{
			array[i] = tempArray[i-1];
		}
		size++;
	}
	
}

/*

 * 	public void addFirst(int data)
	{
		if(size >= capacity)
		{
			expandArr();
		}
		
		int[] tempArray = array;
		array = new int[array.length + 1];
		array[0] = data;
		for(int i = 0; i < tempArray.length; i++)
		{
			array[i + 1] = tempArray[i];
		}
		size++;		
	}
	
			
		int temp[] = null;   
		if (capacity > 0)   
		{   
			temp = new int[capacity];   
			for (int i = 0; i < capacity; i++)   
			{   
				temp[i] = array[i];   
			}   
			size= capacity;   
			array = temp;   
		}   
		

*/
