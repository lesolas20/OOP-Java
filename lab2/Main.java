public class Main {
  // public static int nthIndexOf(StringBuffer text, String str, int n) {
  //   int i = -1;
  //   do {
  //     i = text.indexOf(str, i+1);
  //     --n;
  //   } while (i != -1 && n >= 0);
  //   return i;
  // }

  public static int nthIndexOf(Object text, String str, int n) {
      int i = -1;
      do {
          if (text instanceof StringBuffer) {
              i = ((StringBuffer) text).indexOf(str, i + 1);
          } else if (text instanceof String) {
              i = ((String) text).indexOf(str, i + 1);
          }
          --n;
      } while (i != -1 && n >= 0);
      return i;
  }

  public static void main(String[] args) {
    String delimiter = new String(", ");
    char searchedChar = 'n';

    // 1. Create a character array (university, institute, group, specialty)
    char[] educationalDataChars =
        ("Ukrainian national forestry university, Institute of Computer "
         + "Science and Information Technologies, SWE-21, Software Engineering")
            .toCharArray();

    // char[] educationalDataChars = ("UNFU, ICSIT, SWE-21, SWE").toCharArray();

    String educationalData = new String(educationalDataChars);

    System.out.println("Educational data: " + educationalData);

    if (nthIndexOf(educationalData, delimiter, 2) == -1) {
      System.out.println("Failed to find the delimiter!");
      return;
    }

    // 2. Create text1 by removing the specialty
    int i = educationalData.lastIndexOf(delimiter);
    String text1 = educationalData.substring(0, i);
    System.out.println("Text without the specialty: " + text1);

    // 3. Create text2 as a mirror of text1
    String text2 = new StringBuffer(text1).reverse().toString();
    System.out.println("Mirrored text: " + text2);

    // 4. Create text3 by making text1 uppercase and compare with text1
    String text3 = text1.toUpperCase();
    System.out.println("Uppercase text: " + text3);

    if (text1.equals(text3)) {
      System.out.println("The text is the same as its uppercase variant");
    } else {
      System.out.println("The text is different from its uppercase variant");
    }

    // 5. Extract the institute name from text1
    int instituteStart = text1.indexOf(delimiter) + delimiter.length();
    int instituteEnd = text1.indexOf(delimiter, instituteStart + 1);

    String institute = text1.substring(instituteStart, instituteEnd);
    System.out.println("Institute name: " + institute);

    // 6. Create text4 as the combination of text1 and text3
    String text4 = text1 + " " + text3;
    System.out.println("Concatenated text: " + text4);

    // 7. Find first and last occurrence of a character
    int firstChar = text1.indexOf(searchedChar);
    int lastChar = text1.lastIndexOf(searchedChar);

    if (firstChar == -1 || lastChar == -1) {
      System.out.println("Failed to find the character!");
    } else {
      System.out.println("First occurrence of '" + searchedChar +
                         "' at index: " + firstChar);
      System.out.println("Last occurrence of '" + searchedChar +
                         "' at index: " + lastChar);
    }

    // 8. Create a StringBuffer with data
    StringBuffer studentData = new StringBuffer("Smith, John, Doe, 11, 9, 2001");
    System.out.println("Student data: " + studentData);

    if (nthIndexOf(studentData, delimiter, 4) == -1) {
      System.out.println("Failed to find the delimiter!");
      return;
    }

    // 9. Remove day and month (3, 4)
    int i1 = nthIndexOf(studentData, delimiter, 2);
    int i2 = nthIndexOf(studentData, delimiter, 4);

    studentData.delete(i1, i2);
    System.out.println("Student data with day and month removed: " + studentData);

    // 10. Append place of birth
    studentData.append(delimiter + "New York");
    System.out.println("Student data with place of birth appended: " + studentData);

    // 11. Insert gender after the year
    int i3 = studentData.lastIndexOf(delimiter);

    studentData.insert(i3, delimiter + "Male");
    System.out.println("Student data with gender added: " + studentData);

    // 12. Calculate length in characters and bytes
    int charLength = studentData.toString().length();
    int byteLength = studentData.toString().getBytes().length;
    System.out.println("Length of the text (in characters): " + charLength);
    System.out.println("Length of the text (in bytes): " + byteLength);

    int i4 = nthIndexOf(studentData, delimiter, 2);

    studentData = new StringBuffer(studentData.substring(0, i4));

    System.out.println("Student data with only full name left: " + studentData);

    // 14. Mirror the surname
    int i5 = studentData.indexOf(delimiter);

    String surname = studentData.substring(0, i5);
    String mirroredSurname = new StringBuffer(surname).reverse().toString();
    System.out.println("Mirrored surname: " + mirroredSurname);
  }
}
