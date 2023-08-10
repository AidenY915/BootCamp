interface Readable{}

class OuterClass
{
	public Readable createLocalClassInst()
	{
		class LocalClass
		{

		}

		return new LocalClass();
	}
}