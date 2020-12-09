shop = {
  
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

print(shop)

fruit_check = input("What are you looking for? ").lower()
 
if(fruit_check in shop):
    print("Yes, this is available")
else:
    print("No, this is not available")
