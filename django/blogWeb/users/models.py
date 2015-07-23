# Each model generally corresponds to a single database table
from django.db import models

# Create your models here.
class User(models.Model):
    name = models.CharField(max_length = 10, primary_key = True)
    password = models.CharField(max_length = 20)
    
    def __unicode__(self):
        return self.name

class UserProfile(models.Model):
    user = models.OneToOneField(User)
    selfUrl = models.URLField()
    selfDes = models.CharField(max_length = 50, blank = True)
    blogName = models.CharField(max_length = 20)
    
    def __unicode__(self):
        return self.blogName
    
class Articles(models.Model):
    # same as UserInfo
    user = models.ForeignKey(User)
    
    # Article info
    title = models.CharField(max_length = 20)
    pubDate = models.DateTimeField(auto_now_add = True)
    lastestDate = models.DateTimeField(auto_now = True)
    content = models.TextField()
    privacy = models.CharField(max_length = 10, blank = True)
    
    class Meta:
        ordering = ['pubDate']
    
    def __unicode__(self):
        return self.title
    
