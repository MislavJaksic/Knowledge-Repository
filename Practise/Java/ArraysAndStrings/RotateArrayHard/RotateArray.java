/**
	Problems: "Given an image represented by an NxN matrix, where each pixel in the image is
	4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	place?"
	Discussion: it is done in place; O time in n, linear as we only visit each cell once;
	below is a counterclockwise rotation; I assume I am given N and a single array
	*/
public class RotateArray
{
	public static void main(String[] args)
	{
		int[] picture = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		picture = RotateArrayMethod(picture, 4);
		for (int number : picture)
		{
			System.out.print(number);
		}
	}
	
	public static int[] RotateArrayMethod(int[] picture, int N)
	{
		for (int i = 0; i <= ((N-1)/2); i++)
		{
			int pixel, swapper;
			Position original = new Position();
			Position current = new Position();
			for (int j = i; j < (N - 1 - i); j++)
			{
				pixel = picture[i*1 + j*N];
				original.x = i;
				original.y = j;
				current.x = i;
				current.y = j;
				do
				{
					current = MovePosition(current.x, current.y, N);
					swapper = picture[current.x*1 + current.y *N];
					picture[current.x*1 + current.y*N] = pixel;
					pixel = swapper;
				}while((original.x != current.x) || (original.y != current.y));
			}
		}
		return picture;
	}
	
	public static Position MovePosition(int i, int j, int N)
	{
		Position newPosition = new Position();
		newPosition.x = i + j - i;
		newPosition.y = j + N - 1 - i - j;
		return newPosition;
	}
}

class Position
{
	int x;
	int y;
}