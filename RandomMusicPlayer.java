import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class RandomMusicPlayer
{
	Clip MUSIC;
	AudioInputStream audioInputStream;
	static String filePath;
	public RandomMusicPlayer()
		throws UnsupportedAudioFileException,
		IOException, LineUnavailableException
	{
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		MUSIC = AudioSystem.getClip();
		MUSIC.open(audioInputStream);
		MUSIC.start();
		while(true)
		MUSIC.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public static String getRandomMusic(){
		String RandomMusic[] ={"Untitled.wav","Kaise Hua - Kabir Singh.wav","Kesariya - Brahmastra.wav","Dandelions_320(PagalWorld).wav"}; 
		Random  math = new Random();
		int randomIndex = math.nextInt()%RandomMusic.length ;
		if(randomIndex< 0) randomIndex*=-1;
		System.out.println("Music Library \n");
		for(int i =0 ; i<RandomMusic.length;i++) 
		System.out.println((i+1)+". "+RandomMusic[i]);
		System.out.println("\nRandomly Selecting from "+RandomMusic.length+" Musics\n"+" \nNow Playing -> "+RandomMusic[randomIndex]);
		return RandomMusic[randomIndex];
	}
	public static void main(String[] args)
	{
		try
		{
			filePath = getRandomMusic();
			RandomMusicPlayer audioPlayer = new RandomMusicPlayer();
		}
		catch (Exception ex)
		{
			System.out.println("Please Enter Correct path and format of Music.");
			ex.printStackTrace();
		}
	}
}