# Hybrid Mobile Application Development
## Giới thiệu
Trong phát triển ứng dụng di động lai (HMAD), các ứng dụng di động được phát triển sử dụng công nghệ stack và được đóng gói để triển khai trên nhiều thiết bị di động có kích thước màn hình và nhà sản xuất khác nhau.

Các ứng dụng lai cho phép một nhà phát triển ứng dụng xây dựng một ứng dụng bằng cách sử dụng các công nghệ đơn giản như **HTML**, **CSS**, và **JavaScript**.

Các ứng dụng di động lai cố gắng kết hợp tốt nhất của cả 2 cách tiếp cận; họ sử dụng sức mạnh tính toán phía server nhưng cũng không xem thiết bị chỉ phục vụ như là giao diện người dùng (front  end). Các ứng dụng này có thành phần native nằm trên thiết bị và có thể sử dụng các tính năng cục bộ như một ứng dụng native. Đó là lý do tại sao hybrid apps đang trở nên phổ biến hơn các cách tiếp cận khác.

## Tại sao HMAD?
Việc có thể phát triển một lần và sâu thường là động lực để sử dụng HMAD. Mặc dù như chúng ta đã thảo luận, sử dụng cùng code base, bạn vẫn phải thay đổi khoảng 20% code, dựa trên nền tảng. Tại sao? Giả sử bạn đang nhắm mục tiêu Android và iOS cùng một lúc. Ví dụ, đôi khi các API được sử dụng cho gia tốc kế khác nhau đối với từng nền tảng. Một số thiết bị có thể không có cảm biến.Nguyên tắc chấp nhận từ các kho của ứng dụng của Apple, Google và Microsoft là khác nhau. Cuối cùng, tính nhất quán UI vẫn có thể cho phép trên các nền tảng khác nhau. Tuy nhiên, 20% code lại này còn hơn là tạo tại 100% code cho một nền tảng khác. Vì code có thể **reusability**, HMAD thì luôn luôn tốt hơn.

## Các công nghệ và frameworks được sử dụng trong HMAD
Mặc dù HTML và JavaScript thường được sử dụng trong HMAD, các frameworks sau cũng được sử dụng để giao tiếp với với các thành phần trong thiết bị (device-based) như cảm biến, SD cards, camera:
* Ionic
* PhoneGAP
* Xamarin
* ...

Dựa trên các tính năng được yêu cầu, chi phí, deadlines, ... bạn sẽ quyết định lựa chọn framework nào. 

## Ưu và nhược điểm của HMAD
### Ưu điểm
* Platform-independent
* Phát triển dễ dàng hơn
* Chi phí tốt hơn

### Nhược điểm
* API có liên quan đến tính năng dành riêng cho từng thiết bị hạn chế so với native development
