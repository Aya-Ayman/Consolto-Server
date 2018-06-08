/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

progressBar=document.getElementById("progress");
               urlImage=document.getElementById("urlImage");
               fileButton=document.getElementById("fileInput");
               
                var config = {
    apiKey: "AIzaSyADGR1gpHh1kANt7oZHeyEFttLoFEEBx7I",
    authDomain: "medical-insurance-c04c9.firebaseapp.com",
    databaseURL: "https://medical-insurance-c04c9.firebaseio.com",
    projectId: "medical-insurance-c04c9",
    storageBucket: "medical-insurance-c04c9.appspot.com",
    messagingSenderId: "581321582915"
  };
  firebase.initializeApp(config);
              fileButton.addEventListener('change', function(e){
                  var file = e.target.files[0];
                  var storageRef = firebase.storage().ref(file.name);
                  var fileStore=storageRef.put(file);
                  
                  
                        fileStore.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
  function(snapshot) {
    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
    var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
    console.log('Upload is ' + progress + '% done');
    progressBar.value=progress;
    switch (snapshot.state) {
      case firebase.storage.TaskState.PAUSED: // or 'paused'
        console.log('Upload is paused');
        break;
      case firebase.storage.TaskState.RUNNING: // or 'running'
        console.log('Upload is running');
        break;
    }
  }, function(error) {

  // A full list of error codes is available at
  // https://firebase.google.com/docs/storage/web/handle-errors
  switch (error.code) {
    case 'storage/unauthorized':
      // User doesn't have permission to access the object
      break;

    case 'storage/canceled':
      // User canceled the upload
      break;

    
    case 'storage/unknown':
      // Unknown error occurred, inspect error.serverResponse
      break;
  }
}, function() {
  // Upload completed successfully, now we can get the download URL
  fileStore.snapshot.ref.getDownloadURL().then(function(downloadURL) {
    console.log('File available at', downloadURL);
    urlImage.value=downloadURL;
  });
              });
        
  });       var fileButton = document.getElementById("fileButton");
               progressBar=document.getElementById("progress");
               urlImage=document.getElementById("urlImage");
              fileButton.addEventListener('change', function(e){
                  var file = e.target.files[0];
                  var storageRef = firebase.storage().ref(file.name);
                  var fileStore=storageRef.put(file);
                  
                  
                        fileStore.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
  function(snapshot) {
    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
    var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
    console.log('Upload is ' + progress + '% done');
    progressBar.value=progress;
    switch (snapshot.state) {
      case firebase.storage.TaskState.PAUSED: // or 'paused'
        console.log('Upload is paused');
        break;
      case firebase.storage.TaskState.RUNNING: // or 'running'
        console.log('Upload is running');
        break;
    }
  }, function(error) {

  // A full list of error codes is available at
  // https://firebase.google.com/docs/storage/web/handle-errors
  switch (error.code) {
    case 'storage/unauthorized':
      // User doesn't have permission to access the object
      break;

    case 'storage/canceled':
      // User canceled the upload
      break;

    
    case 'storage/unknown':
      // Unknown error occurred, inspect error.serverResponse
      break;
  }
}, function() {
  // Upload completed successfully, now we can get the download URL
  fileStore.snapshot.ref.getDownloadURL().then(function(downloadURL) {
    console.log('File available at', downloadURL);
    urlImage.value=downloadURL;
  });
              });
        
  });  


