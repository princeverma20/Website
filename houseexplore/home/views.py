from django.shortcuts import render,HttpResponse,redirect
from .models import *
from django.contrib.auth.models import User,auth
from django.contrib import messages
from django.core.mail import send_mail
import json

# Create your views here.
def index(request):
    cards = House.objects.all()
    return render(request,"index.html",{'cards':cards,'locshow':False})


def search(request):
    target=request.GET['searchCity']
    cid=[]
    city_searched = City.objects.filter(city_name__icontains = target)
    for item in city_searched:
        cid.append(item.city_id)
    
    cards = House.objects.filter(city__in=cid)
    locs = Location.objects.filter(city_id__in = cid)
    return render(request,"index.html",{'cards':cards,'locs':locs,'locshow':True})


def contactdealer(request):
    # if request.method == "GET":
    #     print("manas jayaswal")
    #     selectedDealer = Dealer.objects.get(house_id = request.GET['houseid'])
    #     print(selectedDealer)
    # print(selectedDealer)
        # return render(request,"dealer.html",{'selectedDealer':selectedDealer})
    # # print(selectedDealer)
    # # abc = selectedDealer
    if request.method == "GET":
        # print("manas jayaswal is gonna rock")
        global selectedDealer
        selectedDealer = Dealer.objects.get(house_id = request.GET['houseid'])
        # print(selectedDealer)
        # return render(request,"contactdealer.html")
    
    if request.method == "POST":
        # print(selectedDealer)
        name = request.POST['name']
        phone = request.POST['phone']
        email = request.POST['email']
        customer = Customer(customer_name=name,contact_number=phone,email=email)
        customer.save()
        msg1 = "You have contacted Dealer, Here are the details\n" +"name : "+ str(selectedDealer.dealer_name) + "\n" +"email : "+ str(selectedDealer.email_id)  + "\nContact Number : " + str(selectedDealer.contact_number)  + "\n" +"Address : "+ str(selectedDealer.address)
        send_mail(
            'Dealer\'s Information',
            msg1,
            'manas.jayaswal.cse21@itbhu.ac.in',
            [email],
            fail_silently=False,
        )
        msg2 = "A customer is intereseted in your house..\n" + "name : " + str(name) + "\ncontact number : " + str(phone) + "\nemail id : " + str(email)
        send_mail(
            'Customer\'s Information',
            msg2,
            'manas.jayaswal.cse21@itbhu.ac.in',
            [selectedDealer.email_id],
            fail_silently=False,
        )
        return render(request,"dealer.html",{'selectedDealer':selectedDealer})
        # if user.is_authenticated:
        #     print(user.username)
    
        # return redirect("index")
    
    # return render(request,"dealer.html",{'selectedDealer':selectedDealer})

    return render(request,"contactdealer.html")


def signup(request):
    if request.method == "POST":
        fname = request.POST['fname']
        lname = request.POST['lname']
        username = request.POST['username']
        email = request.POST['email']
        pass1 = request.POST['pass1']
        pass2 = request.POST['pass2']
        if pass1 == pass2:
            
            if User.objects.filter(username=username).exists():
                messages.info(request,"This username already exists.")
                return redirect("signup")
            elif User.objects.filter(email=email).exists():
                messages.info(request,"This email is already in use.")
                return redirect("signup")
            else:
                # old code
                user = User.objects.create_user(first_name=fname,last_name=lname,username=username,email=email,password=pass1)
                user.save()
                return redirect("login")
        else:
            messages.info(request,"Passwords are not matching.")
            return redirect("signup")
    else:
        return render(request,"signup.html")

def login(request):
    
    if request.method == "POST":
        username = request.POST['username']
        pass1 = request.POST['pass1']

        user = auth.authenticate(username=username,password=pass1)
        if user is not None:
            auth.login(request,user)
            return redirect("/")
        else:
            messages.info(request,"Invalid Credentials")
            return redirect("login")

    else:
        return render(request,"login.html")

def logout(request):
    auth.logout(request)
    return redirect("/")

# def search(request):
#     searchCards = House.objects.filter(city__icontains=request.GET['searchCity'])
#     return render(request,"search.html",{'searchCards':searchCards})
#     # return HttpResponse("hello this is searchpage")

# def search(request):
#     cities=City.objects.values_list('city_name', flat=True)
#     if(request.GET['searchCity'] in cities):
#         searchCity = City.objects.get(city_name__icontains=request.GET['searchCity'])
#         locs = Location.objects.filter(city_id = searchCity.city_id)
#         searchCards = House.objects.filter(city = searchCity.city_id)
#         return render(request,"search.html",{'searchCards':searchCards,'locs':locs})
#     else:
#         return redirect("/")


def search2(request):
    if request.GET['locSearch'] == "Select the location":   #May be removed
        searchLoc = Location.objects.all()
        return redirect("/")
        # print(123)
        # print(searchLoc)
        # return HttpResponse("you have searched")
    searchLoc = Location.objects.get(loc_name = request.GET['locSearch'])
    # print(type(searchLoc))
    # print(123)
    # print(type(searchLoc.city_id))
    city = City.objects.get(city_id = searchLoc.city_id.city_id)     #two times city id foreign key ka chakkar
    # print((city.city_name))
    searchLocCards = House.objects.filter(location = searchLoc.loc_id)
    locs = Location.objects.filter(city_id = city.city_id)
    return render(request,"search2.html",{'searchLocCards':searchLocCards,'locs':locs})


def dealerinfo(request):
    selectedDealer = Dealer.objects.get(house_id = request.GET['houseid'])
    return render(request,"dealer.html",{'selectedDealer':selectedDealer})

def aboutus(request):
    return render(request,"aboutus.html")


def contactus(request):
    if request.method == "POST":
        fname = request.POST['fname']
        lname = request.POST['lname']
        phone = request.POST['phone']
        email = request.POST['email']
        msg = request.POST['message']
        customercontacted = Customercontacted(first_name = fname,last_name = lname,phone_number = phone,email = email,msg = msg)
        customercontacted.save()
        return redirect("/")
    return render(request,"contactus.html")


def addhouse(request):
    return render(request,"addhouse.html")


# if (City.objects.filter(city_name = request.GET['searchCity']) is None):
#        return HttpResponse("hello this is searchpage")
#     else:

#         cid = City.objects.filter(city_name = request.GET['searchCity'])
#         searchCards = House.objects.filter(city_id = cid)
#         return render(request,"search.html",{'searchCards':searchCards})

#     # # 
#     # cid=City.objects.get(city_name='varanasi').city_id
#     # # 
#     # if cid is not None:
#     #     return render(request,"search.html",{'searchCards':searchCards})
#     # else:
#     #     return HttpResponse("hello this is searchpage")
