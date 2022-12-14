package JuicyCode;

public class ArrayQueue implements QueueInterface
{

	private DynamicArray array;
	int size;
	
	public ArrayQueue()
	{
		array = new DynamicArray();
	}
	
	public ArrayQueue(ArrayQueue queueCopy)
	{
		array = queueCopy.array;
	}

	@Override
	public void enqueue(int value) 
	{
		array.addLast(value);				
	}

	@Override
	public int dequeue() 
	{
		return array.removeFront();
	}

	@Override
	public int peek() 
	{
		return array.getFirst();
	}

	@Override
	public boolean isEmpty() 
	{
		return array.isEmpty();
	}

	@Override
	public int size() 
	{
		return array.getSize();
	}

	@Override
	public void clear() 
	{
		array.clearArr();
	}
	
	public String toString()
	{
		
		String str = array.toString();
		return str;
	}
	
	public int getfrom(int idx)
	{
		return array.getFrom(idx);
	}
}
