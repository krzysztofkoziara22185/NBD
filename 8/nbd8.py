import riak

#create a log file
log = open('/home/kk96/komunikaty.txt','w')

#connect to the port 8087
myClient = riak.RiakClient(pb_port=8087)

log.write("Connected to port 8087"+"\n")


document = {"index":0,"isActive":True,"balance":2149.53,"age":20,"name":"Jan Kowalski"}
bucket='s22185'
key='Jan'

#1 put a document in the db

Bucket = myClient.bucket(bucket)
Jan = Bucket.new(key, data=document)
Jan.store()

log.write("Added an object of key {k} to bucket {b}".format(k=key,b=bucket)+"\n")


#2 get a document 
Jan_get = Bucket.get(key)

assert document == Jan_get.data, 'Fetched wrong value!'
log.write("Fetched an object of key {k} from bucket {b}".format(k=key,b=bucket)+"\n")


#3 print the document

print(Jan_get.data)


#4 modify the document

Jan_get.data["age"]=100
Jan_get.store()

log.write("Modified an object of key {k} from bucket {b}".format(k=key,b=bucket)+"\n")

# get the document again and print
Jan_get = Bucket.get(key)

log.write("Fetched an object of key {k} from bucket {b}".format(k=key,b=bucket)+"\n")
print(Jan_get.data)


#5 delete the document

Jan_get.delete()

assert Bucket.get(key).exists==False, 'The object has not been deleted!'

log.write("An object of key {k} in bucket {b} has been deleted".format(k=key,b=bucket)+"\n")


#6 try to get again
Jan_get = Bucket.get(key)

if (Jan_get.data==None):
    log.write("No object of key {k} in bucket {b}".format(k=key,b=bucket)+"\n")
else:
    log.write("Fetched an object of key {k} from bucket {b}".format(k=key,b=bucket)+"\n")
    print(Jan_get.data)

log.close()

