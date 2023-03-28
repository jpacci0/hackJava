public class Auto { 
  private String color;
  private String[] availableColours = {"rosso", "verde", "blu"};
  
  public Auto(String selectedColor) {
    setColor(selectedColor);
  }
  
  public String getColor() {
    return color;
  }
  
  public void setColor(String selectedColor) {
    for (String availableColour : availableColours) {
      if (availableColour.equals(selectedColor)) {
        color = selectedColor;
        return;
      } else {
        color = "Colore non trovato!";
        return;
      }
    }
  }
}
