<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Old Tweets</title>
</head>
<body>
<h2>You can see all tweets here. You can also set filters below. </h2>
<form action="filter-tweet" method="GET">
    Filter by specific sender:<br>
    <input type="text" name="name">
    <br>
    Filter from specific time:<br>
    <input type="text" name="time">
    Only show each n-th tweet:<br>
    <input type="text" name="nth">
    <br><br>
    <input type="submit" value="Submit">
</form>
<table border=1 cellpadding=3 cellspacing=0>
        <tr>
          <th>Sender</th>
          <th>Message</th>
          <th>Date</th>
        </tr>

        <%
        for (Tweet tweet: tweets) {
            String sender = tweet.getSender();
            String message = tweet.getMessage();
        %>

        <tr>
            <td><% sender %></td>
            <td><% message %></td>
        </tr/>
</table>

<a href="index.html">Go back</a>
</body>
</html>
