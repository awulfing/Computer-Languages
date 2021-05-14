class City(var name : String, var latitude : Double, var longitude : Double)

fun listCities() : List<City>{
  var cities : MutableList<City> = mutableListOf()
  cities.add(City("Atlanta", 33.7490, -84.3880))
  cities.add(City("Bozeman", 45.6770, -111.0429))
  cities.add(City("New York", 40.7128, -74.0060))
  cities.add(City("San Francisco", 37.7749, -122.4194))
  cities.add(City("Tacoma", 47.2529, -122.4443))

  return cities
}	

fun distancefromSeattle(city : City) : Double{
  return haversine(city.latitude, city.longitude, 47.6062, -122.3321)
}

fun haversine(lat1 : Double, lon1 : Double, lat2 : Double, lon2 : Double) : Double{
  val R = 6372.8
  val l1 = Math.toRadians(lat1)
  val l2 = Math.toRadians(lat2)
  val d1 = Math.toRadians(lat2 - lat1)
  val dr = Math.toRadians(lon2 - lon1)
 return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(d1/2), 2.0) + Math.pow(Math.sin(dr/2), 2.0) * Math.cos(l1) * Math.cos(l2))) 
}

fun main(){
  println("*********************Step Two***************************")
	var cityLocation = listCities()
  for(element in cityLocation){
	println("Name: " + element.name + "\t Latitude: " + element.latitude + "\t Longitude: " + element.longitude)
  }

  println("\n*********************Step Three*********************")
  var dist = distancefromSeattle(cityLocation.elementAt(4))
  println("The distance from Seattle to Tacoma: " + dist + " km")
  
  println("\n*********************Step Four*********************")
  println("A list of distances to Seattle: " + cityLocation.map {distancefromSeattle(it)} + "\n")

  println("*********************Step Five*********************")
  var filDistance = cityLocation.filter {distancefromSeattle(it) > 1000}
  println("List of cities over 1000km from seattle\n")
  for (element in filDistance){
	println(element.name +"\n")
  }

  println("*********************Step Six*********************")
  var westDistance = cityLocation.filter { it.longitude < -89.97803}
  println(westDistance.map {it.name})
  
  println("\n*********************Step Seven*********************")
  var maxDistance = cityLocation.maxBy {distancefromSeattle(it)}
  println("Max Distance: " + maxDistance?.name + "\n")

  println("*********************Step Eight*********************")
  var mapCity : MutableMap<String, City> = mutableMapOf()
  for(element in cityLocation){
     mapCity.put(element.name, element)
  }
  for(element in mapCity){
	println("Name: " + element.key + "\t City(" + element.value.name + ", " + element.value.longitude + ", " + element.value.latitude + ")")
  }
  if(mapCity.containsKey("Bozeman")){
	println("Bozeman Latitude: " + mapCity.get("Bozeman")?.latitude)
  }	
  else{
	println("Couldn't find element")
  }
}