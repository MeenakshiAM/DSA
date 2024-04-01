public class ExtraElement {
    public static void main(String[] args) {
        
    }
    static int findExtra(int a[], int b[], int n) {
        // add code here.
        int start=0;
        int end=n-1;
        while(start < end) {
          int mid = start + (end - start) / 2;
          if(a[mid]==b[mid]){
              start = mid + 1;
          }
          else if (a[mid] < b[mid]) {
              end = mid ;
          }
      }
      return end;
}
}
