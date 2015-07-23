from django.shortcuts import render
from users.models import Users, Blogs
from django.contrib.auth.decorators import login_required


# Create your views here.
@login_required(redirect_field_name = '')
def personal_view(request):
    current_user = request.user
    current_path = request.get_full_path()
    # Not Owner of Current page, redirect to the visitor's page
    if not   :
        return 
    
    else:
        
        

