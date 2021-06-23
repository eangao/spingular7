import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'appuser',
        data: { pageTitle: 'spingular7App.appuser.home.title' },
        loadChildren: () => import('./appuser/appuser.module').then(m => m.AppuserModule),
      },
      {
        path: 'blog',
        data: { pageTitle: 'spingular7App.blog.home.title' },
        loadChildren: () => import('./blog/blog.module').then(m => m.BlogModule),
      },
      {
        path: 'post',
        data: { pageTitle: 'spingular7App.post.home.title' },
        loadChildren: () => import('./post/post.module').then(m => m.PostModule),
      },
      {
        path: 'topic',
        data: { pageTitle: 'spingular7App.topic.home.title' },
        loadChildren: () => import('./topic/topic.module').then(m => m.TopicModule),
      },
      {
        path: 'tag',
        data: { pageTitle: 'spingular7App.tag.home.title' },
        loadChildren: () => import('./tag/tag.module').then(m => m.TagModule),
      },
      {
        path: 'comment',
        data: { pageTitle: 'spingular7App.comment.home.title' },
        loadChildren: () => import('./comment/comment.module').then(m => m.CommentModule),
      },
      {
        path: 'notification',
        data: { pageTitle: 'spingular7App.notification.home.title' },
        loadChildren: () => import('./notification/notification.module').then(m => m.NotificationModule),
      },
      {
        path: 'appphoto',
        data: { pageTitle: 'spingular7App.appphoto.home.title' },
        loadChildren: () => import('./appphoto/appphoto.module').then(m => m.AppphotoModule),
      },
      {
        path: 'community',
        data: { pageTitle: 'spingular7App.community.home.title' },
        loadChildren: () => import('./community/community.module').then(m => m.CommunityModule),
      },
      {
        path: 'follow',
        data: { pageTitle: 'spingular7App.follow.home.title' },
        loadChildren: () => import('./follow/follow.module').then(m => m.FollowModule),
      },
      {
        path: 'blockuser',
        data: { pageTitle: 'spingular7App.blockuser.home.title' },
        loadChildren: () => import('./blockuser/blockuser.module').then(m => m.BlockuserModule),
      },
      {
        path: 'interest',
        data: { pageTitle: 'spingular7App.interest.home.title' },
        loadChildren: () => import('./interest/interest.module').then(m => m.InterestModule),
      },
      {
        path: 'activity',
        data: { pageTitle: 'spingular7App.activity.home.title' },
        loadChildren: () => import('./activity/activity.module').then(m => m.ActivityModule),
      },
      {
        path: 'celeb',
        data: { pageTitle: 'spingular7App.celeb.home.title' },
        loadChildren: () => import('./celeb/celeb.module').then(m => m.CelebModule),
      },
      {
        path: 'cinterest',
        data: { pageTitle: 'spingular7App.cinterest.home.title' },
        loadChildren: () => import('./cinterest/cinterest.module').then(m => m.CinterestModule),
      },
      {
        path: 'cactivity',
        data: { pageTitle: 'spingular7App.cactivity.home.title' },
        loadChildren: () => import('./cactivity/cactivity.module').then(m => m.CactivityModule),
      },
      {
        path: 'cceleb',
        data: { pageTitle: 'spingular7App.cceleb.home.title' },
        loadChildren: () => import('./cceleb/cceleb.module').then(m => m.CcelebModule),
      },
      {
        path: 'urllink',
        data: { pageTitle: 'spingular7App.urllink.home.title' },
        loadChildren: () => import('./urllink/urllink.module').then(m => m.UrllinkModule),
      },
      {
        path: 'frontpageconfig',
        data: { pageTitle: 'spingular7App.frontpageconfig.home.title' },
        loadChildren: () => import('./frontpageconfig/frontpageconfig.module').then(m => m.FrontpageconfigModule),
      },
      {
        path: 'feedback',
        data: { pageTitle: 'spingular7App.feedback.home.title' },
        loadChildren: () => import('./feedback/feedback.module').then(m => m.FeedbackModule),
      },
      {
        path: 'config-variables',
        data: { pageTitle: 'spingular7App.configVariables.home.title' },
        loadChildren: () => import('./config-variables/config-variables.module').then(m => m.ConfigVariablesModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
