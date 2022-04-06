<%-- 
    Document   : contact
    Created on : 2022-4-5, 21:43:17
    Author     : Administrater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Contact Us</h1>
                    
                    <div class="alert alert-danger" role="alert">
                        ${alert}
                    </div>
                    
                    <form action="contact" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Joe Blow" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com" required>
                        </div>
                        <div class="mb-3">
                            <label for="message" class="form-label">Example textarea</label>
                            <textarea class="form-control" name="message" id="message" rows="3" required></textarea>
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
