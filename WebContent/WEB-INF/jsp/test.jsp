<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
    <thead>
      <tr>
        <th>Seat Number</th>
        <th>Price</th>
        <th>Update Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${seats}" var="seat">
        <tr>
          <td>${seat.seatNumber}</td>
          <td>${seat.price}</td>
          <td>
            <form id="updateForm-${seat.seatNumber}">
              <input type="hidden" name="seatNumber" value="${seat.seatNumber}">
              <input type="number" name="newPrice" value="${seat.price}">
              <button type="submit">Update</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function() {
      $('form').submit(function(event) {
        event.preventDefault();
        var form = $(this);
        $.ajax({
          url: form.attr('action'),
          type: 'POST',
          data: form.serialize(),
          success: function(data) {
            if (data === 'success') {
              alert('Seat price updated!');
              window.location.reload();
            }
          },
          error: function() {
            alert('Failed to update seat price.');
          }
        });
      });
    });
  </script>
</body>
</body>
</html>