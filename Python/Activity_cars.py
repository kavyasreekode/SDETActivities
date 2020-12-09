class Car:
    
    def __init__(self, manufacturer, model):
        self.manufacturer = manufacturer
        self.model = model

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")
 
    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")
car1 = Car("Toyota", "Corolla")
car2 = Car("Maruti", "800")
car3 = Car("Suzuki", "Swift")
 
car1.accelerate()
car1.stop() 
car2.accelerate()
car3.stop()             