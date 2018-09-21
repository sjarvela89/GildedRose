package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay() {
		//Arrange
		GildedRose store = new GildedRose();
		List<Item> item=null;
		String itemName="Aged Brie"; //Aged brie in slot 0 of the table
		int itemQuality=20;
		int SellIn=11;
		store.addItem(new Item(itemName,SellIn, itemQuality));
		itemName="Sulfuras";//in slot 1 of the table
		itemQuality=80;
		SellIn=11;
		store.addItem(new Item(itemName,SellIn,itemQuality));
		itemName="Backstage passes";//in slot 2 of the table
		itemQuality=20;
		SellIn=11;
		store.addItem(new Item(itemName,SellIn,itemQuality));
		String testListBeforeUpdate=store.getItems().toString();
		item=store.getItems();
		Item[] listArray=new Item[item.size()];
		for(int j=0;j<item.size();j++)
		{
			listArray[j]=item.get(j);
		}
		System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
		int previousDay=0;
		int previousQualityOfPasses=0;
		System.out.println("The quality of the array:"+listArray[2].getQuality());
		/*for(int i=11;i>-10;i--)
		{
			if(i<1&&listArray[2].getQuality()!=0)
			{
				fail("Backstage passes should be 0 by quality");
			}
			if(i<=10&&i>5&&previousQualityOfPasses+2!=listArray[2].getQuality()&&previousQualityOfPasses!=0)
			{
				System.out.println("FAILURE! Quality of the backstage passes. The quality does not rice by two as it should. Prev qual:"+previousQualityOfPasses+"Current qual:"+listArray[2].getQuality());
				fail("Backstage passes quality does not increase by 2, if sellin day is 10 or smaller, but bigger than 5");
			}
			if(i<=5&&i>=0&&previousQualityOfPasses+3!=previousQualityOfPasses&&previousQualityOfPasses!=0)
			{
				System.out.println("FAILURE! Quality of backstage passes does not rice by 3 as should");
				fail("Backstage passes quality does not increase by 3, if selling day is 5 or smaller, but the concers has not gone yet.");
			}
			previousQualityOfPasses=listArray[2].getQuality();
			store.updateEndOfDay();
			previousDay=i;
		}*/
		String testListAfterUpdate=store.getItems().toString();
		//Assert
		if(testListBeforeUpdate==testListAfterUpdate)
		{
			fail("The update did not change content in the tables.");
		}
		assertNotSame(testListBeforeUpdate,testListAfterUpdate);
		System.out.println("The list:"+testListAfterUpdate+"/n Before list:"+testListBeforeUpdate);
	}
	@Test
	public void backstagePassesZeroQualityAfterConcert()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=11;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				int previousDay=0;
				int previousQualityOfPasses=0;
				for(int i=11;i>-10;i--)
				{
					if(i<0&&listArray[2].getQuality()!=0)
					{
						fail("Backstage passes should be 0 by quality");
					}
					previousQualityOfPasses=listArray[2].getQuality();
					GildedRose.updateEndOfDay();
					previousDay=i;
				}
	}
	@Test
	public void backstagePassesQualityIncreaseOfTwo()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=11;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				int previousDay=0;
				int previousQualityOfPasses=0;
				for(int i=11;i>-10;i--)
				{
					if(i<=10&&i>5&&previousQualityOfPasses+2!=listArray[2].getQuality()&&previousQualityOfPasses!=0)
					{
						System.out.println("FAILURE! Quality of the backstage passes. The quality does not rice by two as it should. Prev qual:"+previousQualityOfPasses+"Current qual:"+listArray[2].getQuality());
						fail("Backstage passes quality does not increase by 2, if sellin day is 10 or smaller, but bigger than 5");
					}
					previousQualityOfPasses=listArray[2].getQuality();
					GildedRose.updateEndOfDay();
					previousDay=i;
				}
	}
	@Test
	public void backstagePassesQualityIncreaseOfThree()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=11;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				int previousDay=0;
				int previousQualityOfPasses=0;
				for(int i=11;i>-10;i--)
				{
					if(i<=5&&i>=0&&previousQualityOfPasses+3!=previousQualityOfPasses&&previousQualityOfPasses!=0)
					{
						System.out.println("FAILURE! Quality of backstage passes does not rice by 3 as should");
						fail("Backstage passes quality does not increase by 3, if selling day is 5 or smaller, but the concers has not gone yet.");
					}
					previousQualityOfPasses=listArray[2].getQuality();
					GildedRose.updateEndOfDay();
					previousDay=i;
				}
	}
	@Test
	public void sulfurasAlwaysEighty()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=11;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				int previousDay=0;
				int previousQualityOfPasses=0;
				for(int i=11;i>-10;i--)
				{
					if(listArray[1].getQuality()!=80)
					{
						System.out.println("FAILURE, Sulfuras quality changed. The quality is:"+listArray[1].getQuality());
						fail("Sulfuras quality is incorrect.");
					}
					GildedRose.updateEndOfDay();
					previousDay=i;
				}
	}
	@Test
	public void agedBrieIncreasingDayByDay()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=50;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				int previousDay=0;
				int previousQualityOfBrie=0;
				for(int i=50;i>-1;i--)
				{
					if(previousQualityOfBrie>listArray[0].getQuality() &&previousQualityOfBrie!=0)
					{
						System.out.println("FAILURE! Previous aged brie had better quality than current one.");
						fail("The aged brie did not gather more quality after update.");
					}
					System.out.println("SellIn:"+i);
					previousQualityOfBrie=listArray[0].getQuality();
					GildedRose.updateEndOfDay();
					previousDay=i;
				}
	}
	@Test
	public void agedBrieStaysUnderFifty()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=60;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				System.out.println(listArray[1].getName()+listArray[1].getQuality()+listArray[1].getSellIn());
				//int previousDay=0;
				//int previousQualityOfBrie=0;
				for(int i=60;i>-1;i--)
				{
					if(listArray[0].getQuality()>50)
					{
						System.out.println("FAILURE! Aged Brie above 50 in quality.");
						fail("Aged Brie too good quality.");
					}
					System.out.println("SellIn:"+i);
					//previousQualityOfBrie=listArray[0].getQuality();
					GildedRose.updateEndOfDay();
					//previousDay=i;
				}
	}
	@Test
	public void qualityOfAnItemIsNeverNegative()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=60;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				for(int day=0;day<365;day++)
				{
					for(int j=0;j<item.size();j++)
					{
						if(listArray[j].getQuality()<0)
						{
							System.out.println("The negative quality went into failure section.");
							fail("FAILURE! Quality of some item is negative.");
						}
					}
					GildedRose.updateEndOfDay();
				}
	}
	@Test
	public void qualityDegradesTwiceAsFastAfterPassingSellInDate()
	{
		//Arrange
				GildedRose store = new GildedRose();
				List<Item> item=null;
				String itemName="Aged Brie"; //Aged brie in slot 0 of the table
				int itemQuality=20;
				int SellIn=60;
				store.addItem(new Item(itemName,SellIn, itemQuality));
				itemName="Sulfuras";//in slot 1 of the table
				itemQuality=80;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Backstage passes";//in slot 2 of the table
				itemQuality=20;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				itemName="Basic Items";//in slot 3 of the table
				itemQuality=40;
				SellIn=11;
				store.addItem(new Item(itemName,SellIn,itemQuality));
				String testListBeforeUpdate=store.getItems().toString();
				item=store.getItems();
				Item[] listArray=new Item[item.size()];
				for(int j=0;j<item.size();j++)
				{
					listArray[j]=item.get(j);
				}
				int previousDayQuality=51;
				int firstDegrateValue=0;
				boolean firstDegrateValueSaved=false;
				for(int day=0;day<365;day++)
				{
					if(!firstDegrateValueSaved)
					{
						if(previousDayQuality!=51)
						{
							firstDegrateValue=previousDayQuality-listArray[3].getQuality();
							firstDegrateValueSaved=true;
						}
					}
					if(previousDayQuality!=51&&listArray[3].getSellIn()<0&&2*firstDegrateValue!=previousDayQuality-listArray[3].getQuality())
					{
						System.out.println("FAILURE! SellIn value degrading. Previous quality:"+previousDayQuality+"Current quality:"+listArray[3].getQuality()+"Day now:"+day);
						fail("FAILURE! After SellIn value gone, the items quality does not degrade twise as fast.");
					}
					previousDayQuality=listArray[3].getQuality();
					GildedRose.updateEndOfDay();
				}
	}
}
