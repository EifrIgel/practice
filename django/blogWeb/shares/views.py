# Once SessionMiddleware activated, every HttpRequest instance has session property
from django.shortcuts import render

from django.contrib.auth import authenticat, login, logout
# Create your views here.
def login_view(request):
    user = authenticate(username = request.POST['username'], password = request.POST['password'])
    if user is not None and user.is_active:
        login(request, user)
        return HttpResponseRedirect('/users/username')
    else:
        # Redirect to signin-signup page
        return HttpResponseRedirect('/accounts')

def logout_view(request):
    logout(request)
    # After logout, return to the homePage automatically
    return HttpResponseRedirect()

def signup_view(request):
    if request.user.is_authenticated():
        username = 
        return HttpResponseRedirect('/users/username')
    
    try:
        if request.method == 'POST':
            username = request.POST['username']
            password1 = request.POST['password1']
            password2 = request.POST['password2']
            email = request.POST['email']
            
            infoForm = UserCreatetionForm({'username':username, 'password1':password1, 'password2':password2, 'email':email})
            if infoForm.is_valid():
                new_user = infoForm.save()
                return HttpResponseRedirect('/users/username')
            
            ir not signupFrom
            
            